APP=lcta

start-dev:
	./gradlew installDist -t & ./gradlew run -t

deploy:
	git push heroku master


