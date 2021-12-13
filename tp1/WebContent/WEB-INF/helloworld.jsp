<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Météo du monde</title>
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.0"></script>
<script src="https://cdn.tailwindcss.com"></script>
<script>
	// when life is settled, load up the fun stuff
	document.addEventListener('DOMContentLoaded', function() {
		new Vue({
			el : '#app',
			// define data - initial display text
			data : {
				m1 : "You got to let me know"
			}
		})
	})
</script>
</head>
<body>
	<div id="app">
		<h1 class="p-6 border-b shadow text-2xl font-bold">Météo de Gulli
			!</h1>
		<form class="p-6">
			<label class="mb-2 block font-bold">Mettez à jour la
				température d'un pays</label> <label for="newTemp">Nouvelle
				température:</label> <input type="number" class="border p-1 rounded ml-2 outline-none"
				id="newTemp" name="newTemp">
			<div>
				<label class="mr-2">Selectionnez un pays: </label> <select
					class="p-1 border mt-2">
					<option>France</option>
					<option>Beijing</option>
					<option>Italy</option>
				</select>
			</div>
			<button type="submit" class="p-2 bg-blue-400 rounded mt-3 hover:shadow-md hover:bg-blue-500 text-white text-sm">Mettre à jour</button>
		</form>
		<div class="p-6">
			<ul>
				<li>Bonjour</li>
				<li>Bonjour</li>
				<li>Bonjour</li>
			</ul>
		</div>
	</div>
</body>
</html>