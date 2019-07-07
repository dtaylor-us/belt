BASEDIR=$(PWD)

###### DEV ######
dev-build: clean-ui dev-build-ui build-styles
dev: build-styles dev-ui--run

dev-build-ui:
	lein cljsbuild once

dev-ui--run:
	lein figwheel app


###### APP ######
app: build-styles app-build-ui start-app

app-build-ui: clean-ui
	lein package

start-app:
	mvn spring-boot:run


###### COMMON ######
clean-ui:
	lein clean

build-styles:
	npm run build
