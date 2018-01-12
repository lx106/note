#!/bin/bash
# ping all ip 一个Hello 级别的shell脚本 ping hosts中的所有ip地址
cat /etc/hosts | grep -v '^#' | while read LINE
do
	ADDR= `awk '{print $1}'`
	for MACHINE in $ADDR
	do 
		ping -s -cl $MACHINE
	done
done				