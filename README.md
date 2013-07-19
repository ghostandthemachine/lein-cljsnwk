#lein-cljsnwk
----

### Usage
[Node-webkit](https://github.com/rogerwang/node-webkit), the [popular](https://github.com/rogerwang/node-webkit/wiki/List-of-apps-and-companies-using-node-webkit) app runtime based on Chromium and node.js, allows for native applications to be built using modern web technologies like HTML, CSS, and Javascript. This project aims to provide a turnkey template for developing node-webkit applications using Clojurescript.

This project is a work in progress and should be considered experimental etc. It has only been tested on OSX so far.

### Features
* Easy configuration of loading CSS and Javascript dependencies all in Clojurescript
* Easily editable configuration for
	+ node.js package for node-webkit
	+ application js and CSS dependencies 
	+ cljsbuild configurations
* All configuration is handled initially to allow for little to no startup time to get running with node-webkit and Clojurescript
* Support for browser connected REPL to running node-webkit applications


### Resources
This template is built on a few key components

* [leiningen](https://github.com/technomancy/leiningen) and lein-new
* [node-webkit](https://github.com/rogerwang/node-webkit)
* [Clojurescript](https://github.com/clojure/clojurescript)
* [cljsbuild](https://github.com/emezeske/lein-cljsbuild)

----

# Walkthrough
*NOTE: This walkthrough will be based on an OSX configuration. Additional information on configuring for Linux and Windows can be found in the [node-webkit documentation](https://github.com/rogerwang/node-webkit/wiki)*

##Quick Start
1. Download node-webkit binary
	+ node-webkit [downloads](https://github.com/rogerwang/node-webkit#downloads)
2. Create new project using lein new cljsnwk
	+ `$ lein new cljsnwk my- project`
3. Open project directory
	+ `$ cd ../my-project`
4. Install node modules
	+ `$ npm install`
5. Make runner script executable
	+ `$ chmod u+x my-project/script/my-project`
6. Run cljsbuild
	+ `$ lein cljsbuild auto`
7. Start browser connected REPL (optional)
8. Start node-webkit application
	+ `$ ./my-project/script/my-project`
	
After steps 1-4 have been done initially, they will not be needed to run the application. For new projects, the node modules *will* need to be installed per project and the generated runner script made executable.


##Detailed Start

####Download binary
Before running a node-webkit project the node-webkit binary must be downloaded. This can be done from the node-webkit project repository's [downloads](https://github.com/rogerwang/node-webkit#downloads) section.

On OSX, the binary should be placed in the Applications directory `/Applications/node-webkit.app`.

####Creating New cljsnwk Project
Using lein-new, a project can be created by running

`$ lein new cljsnwk my-project`

This will create a new cljsnwk project with the following initial structure

- project-root
	+ public
		* js
			- compiled project cljs source file
		* css
		* images
	+ script
		* application run script
	+ src
		* project clj/cljs source
	+ test
	+ app.js for browser connection
	+ package.json
	+ project.clj
	
After to project is creating, cd into the root directory.

`$ cd ../projects/my-project`

####Install Node Modules
Before this step, make sure you have installed node and/or brought it up to date. In OSX with homebrew:

`$ brew install node`

or to update

`$ brew upgrade node`

`node.js` dependencies are maintained in the `package.json` file at the root of the project. Initially, the only dependency included by cljsnwk is for serving the application locally to support REPL connection.

After creating the project the `node.js` dependencies can be installed with npm like so:

from project root

`$ npm install`

####Running Without Local Server
Serving the project files on a local web server is not required for running the application. Only for connecting to the running application from a browser connected REPL. This can be changed by editing the runner script and the package.json file like so:

package.json

```json
{
  "name": "My Project",
  "main": "http://localhost:3000/index.html",
  "version": "0.1.0",
  "window": {
    "title": "{{name}}",
    "width": 1200,
    "height": 800,
    "show":   true,
    "toolbar": true,
    "resizable": true
  },
  "node-remote": "<local>",
  "devDependencies": {
    "connect" : "*"
  }
}
```

will change to 

```json
{
  "name": "My Project",
  "main": "index.html",
  "version": "0.1.0",
  "window": {
    "title": "{{name}}",
    "width": 1200,
    "height": 800,
    "show":   true,
    "toolbar": true,
    "resizable": true
  }
}
```


####Make Script Executable
For convenience, there is a script included to run the project as well as fire up the node.js local web server. This must first be made executable:

`$ chmod u+x my-project/script/my-project`

####Run cljsbuild
Compile once or with file watch auto compilation:

from project root

`$ lein cljsbuild once`

or

`$ lein cljsbuild auto`

See the [cljsbuild](https://github.com/emezeske/lein-cljsbuild) documentation for more detailed information.

####Start Browser Connected REPL
NOTE: For this to work, the clojurescript from the application must call the clojure.browser.repl/connect function. This can be done manually passed as a flag in the initial configuration map in my-project/src/my_project/core.cljs
	 
Using either the standard cljsbuild browser configuration or something like SublimeREPL (the Clojurescript Browser REPL in the most recent release), start the browser connected REPL.

#####Start node-webkit Application


Using the script, the application can be started:

`$ ./project/script/my-project`

This will start the node.js web server to host the files as well as start the node-webkit binary using the project.

The browser connected REPL should connect and the index.html page should now load.


##Contributions
Contributions are strongly encouraged. Please feel free to form and issue pull requests etc.



## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
 