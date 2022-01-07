from .models import Country, Region
from rest_framework import serializers


class RegionSerialier(serializers.ModelSerializer):
    class Meta:
        model = Region
        fields = '__all__'


class CountrySerialier(serializers.ModelSerializer):
    regions = RegionSerialier(many=True, read_only=True)

    class Meta:
        model = Country
        fields = ['pk', 'name', 'president', 'regions']
