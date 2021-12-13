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
				countries : "${weatherlist}"
			}
		})
	})
</script>
</head>
<body>
	<div id="app">
		<div class="p-6 border-b shadow flex items-center">
			<h1 class="text-2xl font-bold">Météo de Gulli !</h1>
			<img alt="theo"
				class="w-12 h-12 rounded-full shadow object-cover ml-6"
				src="https://pbs.twimg.com/media/EEdYYn7WwAEcPaI.jpg">
		</div>

		<form class="p-6">
			<label class="mb-2 block font-bold">Mettez à jour la
				température d'un pays</label> <label for="newTemp">Nouvelle
				température:</label> <input type="number"
				class="border p-1 rounded ml-2 outline-none" id="newTemp"
				name="newTemp">
			<div>
				<label class="mr-2">Selectionnez un pays: </label> <select
					class="p-1 border mt-2">
					<option v-for="(country, index) in countries" :key="index">{{country}}</option>
				</select>
			</div>
			<button type="submit"
				class="p-2 bg-blue-400 rounded mt-3 hover:shadow-md hover:bg-blue-500 text-white text-sm">Mettre
				à jour</button>
		</form>
		<div class="px-6 py-4">
			<table class="">
				<thead>
					<tr class="bg-gray-100 rounded">
						<th class="px-6 py-4 text-left">Pays</th>
						<th class="px-6 py-4 text-left">Capitale</th>
						<th class="px-6 py-4 text-left">Température (°C)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${weatherlist}" var="weather">
						<tr>
							<td class="px-6 py-4"><c:out value="${weather.countryName}" /></td>
							<td class="px-6 py-4"><c:out value="${weather.countryCapital}" /></td>
							<td class="px-6 py-4"><c:out value="${weather.countryTemp}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>