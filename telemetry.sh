#!/bin/bash

# Function to clean up background processes
cleanup() {
  echo "Cleaning up background processes..."
  pkill -P $$
  exit 0
}

# Set trap to call cleanup function on script exit
trap cleanup EXIT

# Download the OpenTelemetry Java Agent
curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar

# Set the OpenTelemetry Java Agent path
OTEL_AGENT_PATH="$(pwd)/opentelemetry-javaagent.jar"

# Export necessary environment variables for OpenTelemetry
export JAVA_TOOL_OPTIONS="-javaagent:${OTEL_AGENT_PATH}"
export OTEL_TRACES_EXPORTER=logging
export OTEL_METRICS_EXPORTER=logging
export OTEL_LOGS_EXPORTER=logging
export OTEL_METRIC_EXPORT_INTERVAL=15000

# Start the Java application
java -jar target/*.jar &

# Get the PID of the Java application
JAVA_PID=$!

# Initialize counters for responses and errors
TOTAL_RESPONSES=0
ERROR_RESPONSES=0

# Function to monitor CPU and Memory usage
monitor_resources() {
  while true; do
    # Capture CPU and Memory usage
    CPU_USAGE=$(ps -p $JAVA_PID -o %cpu= | awk '{printf "%.2f", $1}')
    MEM_USAGE=$(ps -p $JAVA_PID -o %mem= | awk '{printf "%.2f", $1}')

    # Pretty print CPU and Memory usage
    echo "-------------------------------"
    echo "|       Resource Usage        |"
    echo "-------------------------------"
    printf "| %-15s | %-10s |\n" "Metric" "Value"
    echo "-------------------------------"
    printf "| %-15s | %-10s |\n" "CPU Usage (%)" "${CPU_USAGE}"
    printf "| %-15s | %-10s |\n" "Memory Usage (%)" "${MEM_USAGE}"
    echo "-------------------------------"

    # Wait for 15 seconds before the next check
    sleep 15
  done
}

# Function to monitor response times and error rates
monitor_application_metrics() {
  while true; do
    # Capture response times
    RESPONSE_TIMES=$(curl -s -o /dev/null -w "%{time_total}" http://your-application-endpoint)
    # Capture HTTP status code
    HTTP_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://your-application-endpoint)

    # Increment total responses counter
    ((TOTAL_RESPONSES++))

    # Increment error responses counter if HTTP status code is 500 or greater
    if [ "$HTTP_CODE" -ge 500 ]; then
      ((ERROR_RESPONSES++))
    fi

    # Calculate error rate in percent
    ERROR_RATE_PERCENT=$(awk "BEGIN {printf \"%.2f\", ${ERROR_RESPONSES}/${TOTAL_RESPONSES}*100}")

    # Pretty print response times and error rates
    echo "-------------------------------"
    echo "|       Application Metrics   |"
    echo "-------------------------------"
    printf "| %-15s | %-10s |\n" "Metric" "Value"
    echo "-------------------------------"
    printf "| %-15s | %-10s |\n" "Response Time (s)" "${RESPONSE_TIMES}"
    printf "| %-15s | %-10s |\n" "Error Rate (%)" "${ERROR_RATE_PERCENT}"
    echo "-------------------------------"

    # Wait for 15 seconds before the next check
    sleep 15
  done
}

# Start monitoring resources and application metrics in the background
monitor_resources &
monitor_application_metrics &

# Wait for the Java application to finish
wait $JAVA_PID
