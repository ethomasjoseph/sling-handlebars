# Apache Sling Handlebars Scripting Support 

## Getting Started =============== 

This component uses a Maven 2 (http://maven.apache.org/) build 
environment. It requires a Java 5 JDK (or higher) and Maven 
(http://maven.apache.org/) 2.0.7 or later. We recommend to use the 
latest Maven version. 

If you have Maven 2 installed, you can compile and package the jar using 
the following command: 

mvn package 

See the Maven 2 documentation for other build features. 

## Source Code 

This code was originally written by Ian and can be found at [Apache's 
Sling SVN repository](http://svn.apache.org/repos/asf/sling/whiteboard/ieb/handlebars).

## New Features & Improvements
This fork of the code enhances the original code.

### New Features
* Allows the Handlebars compiler to be published as an OSGi service, and made available in Sling Bindings. In the absence of Sling bindings, a default simple Handlebars compiler will be used.
* Added the HandlebarsHelperService interface under which Handlebars Helpers can be published

### Improvements
* Upgraded the parent POM version
* HandlebarsScriptEngineFactory now creates the HandlebarsScriptEngine only once.

