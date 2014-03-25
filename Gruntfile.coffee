# Build configurations.
module.exports = (grunt) ->
	grunt.initConfig
		connect:
			app:
				options:
					base: './Angular Android/src/main/assets/application'
					port: 5000
					livereload: false
					keepalive: true
					watch: false

	grunt.loadNpmTasks 'grunt-contrib-connect'
	grunt.registerTask 'default', ['connect']
