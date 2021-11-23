#!/bin/bash

echo "Enter the number of values want to take as input:"
read num

declare -a values
for ((i=0;i<num;i++))
do
  read a
  values+=( $a )
done

for ((i=0;i<num;i++))
do
  for ((j=0;j<5-i-1;j++))
  do
    if [ ${values[j]} -gt ${values[$((j+1))]} ]
    then
      tmp=${values[j]}
      values[$j]=${values[$((j+1))]}  
      values[$((j+1))]=$tmp
    fi
  done
done

echo "Sorted Answer:"
echo ${values[*]}