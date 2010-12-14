PROJECT_NAME = "MahJongCore"
INCLUDE_SRC = true
CREATE_JAVADOC = true
MAIN_CLASS = false
#MAIN_CLASS = "Hello"

require 'ant'

SRC_DIR = "src"
CLASS_DIR = "bin"
LIB_DIR = "lib"
DIST_DIR = "dist"
JAVADOC_DIR_NAME = "doc"
JAVADOC_DIR = "dist/" + JAVADOC_DIR_NAME
ENCODING = "UTF-8"

directory CLASS_DIR

desc "compile .java and create .class"
task "compile" => CLASS_DIR do
	ant.javac :srcdir => SRC_DIR, :destdir => CLASS_DIR, :encoding => ENCODING do
		FileList.new(LIB_DIR + "/**/*.jar").each do |f|
			classpath :location => f
		end
	end
	ant.copy :todir => CLASS_DIR do
		fileset :dir => SRC_DIR do
			exclude :name => "**/*.java"
		end
	end
end

JAR_FILE = PROJECT_NAME + ".jar"

desc "create jar"
file JAR_FILE => "compile" do
	ant.jar({
		:destfile => JAR_FILE,
		:basedir => CLASS_DIR,
		:excludes => "**/test, **/test/**/*",
		:update => true
	}) do
		fileset :dir => SRC_DIR, :includes => "**/*.java" if INCLUDE_SRC
		manifest do
			if MAIN_CLASS
				attribute :name => "Main-Class", :value => MAIN_CLASS
				classpath = FileList.new(LIB_DIR + "/**/*.jar").join(" ")
				attribute :name => "Class-Path", :value => classpath
			end
		end
	end
end

desc "create jar(aliase of \"#{JAR_FILE}\")"
task "jar" => JAR_FILE

directory DIST_DIR
directory JAVADOC_DIR

desc "create javadoc"
task "javadoc" => JAVADOC_DIR do
	ant.javadoc({
		:sourcepath => SRC_DIR,
		:destdir => JAVADOC_DIR,
		:encoding => ENCODING
	}) do
		sourcefiles do
			fileset :dir => SRC_DIR, :includes => "*.java"
		end
		FileList.new(LIB_DIR + "/**/*.jar").each do |f|
			classpath :location => f
		end
	end
	destfile = DIST_DIR + "/" + PROJECT_NAME + "-doc.zip"
	includes = JAVADOC_DIR_NAME + "/**/*"
	ant.zip :destfile => destfile, :basedir => DIST_DIR, :includes => includes
end

desc "put builds in dist dir"
task "deploy" => [JAR_FILE, DIST_DIR] do
	if MAIN_CLASS
		destfile = DIST_DIR + "/" + PROJECT_NAME + ".zip"
		includes = "#{JAR_FILE},#{LIB_DIR}/**/*.jar"
		ant.zip :destfile => destfile, :includes => includes, :basedir => "./"
	end
	mv JAR_FILE, DIST_DIR
end

require 'rake/clean'

CLEAN.include CLASS_DIR
CLEAN.include JAR_FILE
CLEAN.include JAVADOC_DIR
CLOBBER.include DIST_DIR

desc "build"
if CREATE_JAVADOC
	task "build" => ["deploy", "javadoc"]
else
	task "build" => "deploy"
end

task "default" => "build"
