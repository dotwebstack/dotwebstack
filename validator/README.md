# Validator

The validator should be used to check whether the `elmo2.ttl` and `elmo-shacl.ttl` files are correct.
For testing purposes, the files in the `/vocabulary/example` directory are used to check the `elmo2.ttl` and `elmo-shacl.ttl` files.

Usage:

	validate.bat
  
Results will be logged in the file `report.ttl`, you would like to have the following result:

	[ a            sh:ValidationReport ;
	  sh:conforms  true
	] .
