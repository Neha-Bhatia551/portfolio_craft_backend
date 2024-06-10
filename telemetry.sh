#!/bin/bash

curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar

OTEL_AGENT_PATH="$(pwd)/opentelemetry-javaagent.jar"

export JAVA_TOOL_OPTIONS="-javaagent:${OTEL_AGENT_PATH}"
export OTEL_TRACES_EXPORTER=logging
export OTEL_METRICS_EXPORTER=logging
export OTEL_LOGS_EXPORTER=logging
export OTEL_METRIC_EXPORT_INTERVAL=15000
