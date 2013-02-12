#! /bin/bash
# Launch script for cs_eda016

# Check if ./bin/ exists.
dir=./bin/parser/
if [ -d $dir ]; then
	echo "$dir exists, proceeding ..."
else
	echo "$dir does't exist, please run install.sh ... "
	exit 0
fi

#Select what to run.
PS3='Choose a package to use: '
select package in $( ls $dir ); do

	# Select a classfile.
	PS3='Choose a file to run: '
	select classfile in $( ls $dir/$package ); do

		# This project needs ExprFiles as arguments to java
		PS3='Choose an ExprFile: '
		select exprfile in $( ls ); do
			classfile=`echo $classfile | sed 's/\..\{5\}$//'`
			cd $dir

			# Execute
			java "$package"."$classfile" ../../"$exprfile"
			exit 0
			done
			break
	done
	break
done
break

exit 0
