#!/bin/bash --login
set -e

# Install javascript dependencies
node --version
npm install
node node_modules/.bin/typings install

# Install ruby dependencies
rvm install 2.3.0
rvm use 2.3.0
rvm rubygems latest
ruby --version

# Install bundler
bundle install
