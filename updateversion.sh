oldversion='0.7.5'
newversion='0.7.5'
grep -Ir "$oldversion" * | cut -d ':' -f1 |uniq |xargs  sed -i s/"$oldversion"/"$newversion"/g
