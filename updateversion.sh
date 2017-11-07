source ./version.sh
grep -Ir "$oldversion" * | cut -d ':' -f1 |uniq |xargs  sed -i s/"$oldversion"/"$newversion"/g
