oldversion='0.7.4'
newversion='0.7.4'
grep -Ir "$oldversion" * | cut -d ':' -f1 |uniq |xargs  sed -i s/"$oldversion"/"$newversion"/g
