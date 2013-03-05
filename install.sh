#! /bin/bash
# Build script for cs_eda016

# Function for checking if ./bin exists
dir=./bin
if [ -d $dir ]; then
	echo "$dir exists, proceeding ..."
else
	echo "$dir doesn't exist, creating ..."
	mkdir -v $dir
fi

# Function for compiling.
function build() {
if [ -d $1/$2 ]; then
	echo "$1/$2 exists, proceeding ..."
else
	echo "$1/$2 doesn't exist, creating ..."
	mkdir -v $1/$2
fi

# Compile
javac -verbose -d $1/$2/ ./src/$2/*.java
}

f=parser
# Select and build a folder.
build $dir $f

exit 0
