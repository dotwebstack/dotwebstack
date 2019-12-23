cd ..
java -jar validator/target/validator-0.0.1-SNAPSHOT-jar-with-dependencies.jar "vocabulary/examples/*.trig" "vocabulary/elmo/*.ttl" vocabulary/elmo-shacl.ttl validator/report.ttl
cd validator
