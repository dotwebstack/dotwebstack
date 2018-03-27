@echo off
cd ..
java -jar validator/target/validator-0.0.18-SNAPSHOT-jar-with-dependencies.jar "vocabulary/examples/*.trig" "vocabulary/elmo/*.ttl" vocabulary/elmo-shacl.ttl
pause
