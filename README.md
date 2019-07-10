## Perquisites

*  JDK
*  [leiningen](https://leiningen.org/)
*  [npm](https://www.npmjs.com/get-npm)
*  docker

## Stack

#### Front End
*  [Reagent (cljs)](https://reagent-project.github.io/)
*  [Material Design (web)](https://material.io/develop/web/)

#### Back End
*  Spring Boot (groovy)
*  Mysql (spring data / hibernate)

#### Leveraging
* Docker
* Heroku (deployment)

### Run App Locally
Terminal A

    mvn spring-boot:run
    
Ternminal B

    make dev

wait for both to complete.
    
    dev server: http://localhost:3449/index.html
    app server: http://localhost:8080/

#### Additional compilation References
    
#### Reagent
To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser.

##### REPL

The project is setup to start nREPL on port `7002` once Figwheel starts.
Once you connect to the nREPL, run `(cljs)` to switch to the ClojureScript REPL.

##### Building for production

```
lein clean
lein package
```

### Material Design
Start dev server

    npm run start
    
build

    npm run build
    
### Spring boot
run application

    mvn spring-boot:run