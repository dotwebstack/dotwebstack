@echo off
cd ..
java -cp "validator/target/*;validator/target/lib/*" org.dotwebstack.validator.Validator "vocabulary/validation-test.ttl" "vocabulary/elmo/*.ttl" vocabulary/elmo-shacl.ttl
pause
