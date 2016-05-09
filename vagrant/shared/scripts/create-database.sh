#!/bin/bash

DATABASE_NAME=dbASW

function createDatabase {
	echo "======================="
	echo "creating dababase ${DATABASE_NAME}"
	echo "======================="
	. ~db2inst1/sqllib/db2profile
	db2 create database ${DATABASE_NAME}
}

createDatabase
