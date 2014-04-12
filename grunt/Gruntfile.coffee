# Build configurations.
module.exports = (grunt) ->
	grunt.initConfig
		connect:
			app:
				options:
					base: '../Angular Android/src/main/assets/application'
					port: 5001
					livereload: false
					keepalive: true
					watch: false
					middleware: require './middleware'

	grunt.loadNpmTasks 'grunt-contrib-connect'
	grunt.registerTask 'default', ['connect']
