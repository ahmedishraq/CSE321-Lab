#!/bin/bash

echo "Enter a number"
read num
val=$num

while [ $val != 1 ] && [ $val != 4 ]
do
  sum=0
  rem=0
  while [ $val -gt 0 ]
  do
    rem=$(($val%10))
    val=$(($val/10))
    tmp=$(($rem*$rem))
    sum=$(($sum+$tmp))
  done
  val=$sum
done

if [ $val -eq 1 ];
then
  echo "$num is a Happy Prime Number"
elif [ $val -eq 4 ];
then
  echo "$num is not a Happy Prime Number"
fi

