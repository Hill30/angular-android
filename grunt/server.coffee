module.exports = (app, options) ->

	todos=[]

	app.get '/', (req, res) ->
		res.render "#{options.base}/index.html"

	app.get '/api/list', (req, res) ->
		res.json todos

	app.post '/api/update/:id', (req, res) ->
		todos[req.params.id] = req.body
		res.send 200

	app.post '/api/add/:id', (req, res) ->
		todos.splice parseInt(req.params.id)+1, 0, req.body
		res.send 200

	app.post '/api/delete/:id', (req, res, id) ->
		todos.splice req.params.id, 1
		res.send 200
