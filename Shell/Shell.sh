#!/bin/bash
# ping all ip һ��Hello �����shell�ű� ping hosts�е�����ip��ַ
cat /etc/hosts | grep -v '^#' | while read LINE
do
	ADDR= `awk '{print $1}'`
	for MACHINE in $ADDR
	do 
		ping -s -cl $MACHINE
	done
done				