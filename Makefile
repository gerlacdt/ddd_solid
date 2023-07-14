.PHONY: build fmt

build:
	mvn clean package

fmt:
	mvn spotless:apply
