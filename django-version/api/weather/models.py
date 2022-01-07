from django.db import models


class Country(models.Model):
    name = models.CharField(max_length=50)
    president = models.CharField(max_length=50)

    def __str__(self):
        return f"{self.name} - {self.president}"


class Region(models.Model):
    name = models.CharField(max_length=50)
    temperature = models.IntegerField()
    country = models.ForeignKey(
        Country, related_name='regions', on_delete=models.CASCADE)

    class Meta:
        ordering = ['name']

    def __str__(self):
        return f"{self.name} - {self.temperature} - {self.country.pk}"
