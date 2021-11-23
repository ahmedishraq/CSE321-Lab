#!/bin/bash

echo "Enter a number: "
read num
ac=$(($num%4))
bc=$(($num%5))
dc=$(($num%10))
ec=$(($num%6))

if [ $ac -ne 0 ];
then
  if [ $bc -ne 0 ];
  then
    if [ $dc -eq 0 ];
    then
     echo "Rasengan"
    fi
  fi
elif [ $bc -eq 0 ];
then
 echo "Oodama Rasengan1"
elif [ $ec -eq 0 ];
then
 echo "Oodama Rasengan2"
elif [ $bc -eq 0 ];
then 
  if [ $ec -eq 0 ];
  then
   echo "Rasen Shuriken"
  fi
fi
