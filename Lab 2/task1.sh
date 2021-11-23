#!/bin/bash
sum=0

declare -a values
for ((i=0;i<10;i++))
do
  read a
  values+=( $a )
done

for ((i=0;i<${#values[@]};i++))
do
  ui=${values[i]}
  ac=$(($ui%2))
if [ $ac -eq 0 ];
then
  bc=$(($ui%8))
if [ $bc -ne 0 ];
then
 sum=$(($sum+ui))
fi
fi
done
echo "Sum of the integers: $sum"
