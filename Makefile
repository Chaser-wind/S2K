.PHONY: clean all run

S2K:
	javac S2K.java

all: S2K


clean:
	rm -f *.class ./syntaxtree/*.class ./visitor/*.class ./kanga/*.class