#!/bin/bash
set -e

dev=0
if [ "a$1" == "adev" ]; then
    dev=1
fi

function prefixOutput() {
    while read line; do
        echo "$1$line"
    done
}

# Update the PATH
source ~/.rvm/scripts/rvm
rvm use 2.3.0
PATH=$PATH:node_modules/.bin/:$(bundle show jekyll)/exe/

# Transpile typescipts
if [ $dev -eq 1 ]; then
    tsc -p . --sourceMap -w | prefixOutput "[TypeScript] " &
else
    tsc -p . --sourceMap || true
fi

# Build Jekyll content
if [ $dev -eq 1 ]; then
    jekyll serve -H 0.0.0.0 | prefixOutput "[Jekyll]     " &
else
    jekyll build
fi

# Run the development server in the background
if [ $dev -eq 1 ]; then
    echo "Press any key to shut down the development server."
    read -sN1
    kill $(jobs -p)
fi
