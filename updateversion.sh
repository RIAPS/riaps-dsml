oldversion='0.8.1'
newversion='0.8.1'
grep -Ir "$oldversion" * | cut -d ':' -f1 |uniq |xargs  sed -i s/"$oldversion"/"$newversion"/g
