help:
	@echo "The following make commands are valid, and can be run as 'make COMMAND':"
	@echo ""
	@echo "  jar  compiles the library into a jar file"
	@echo "  doc  generates the documentation for the library"
	@echo ""

jar:
	gradle jar

doc:
	gradle javadoc
