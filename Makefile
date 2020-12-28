APP=lcta

start-dev:
	./gradlew run -t

auto-reload:
	./gradlew installDist -t

deploy:
	git push heroku master


