mvn clean
mvn compile
mvn package

java -jar target/DataComparator-1.0.0.jar data/a.txt data/b.txt > diff.txt

