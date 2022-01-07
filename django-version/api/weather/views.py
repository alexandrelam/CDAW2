from weather.serializers import CountrySerialier, RegionSerialier
from weather.models import Country, Region
from rest_framework import viewsets


# Create your views here.


class CountryViewSet(viewsets.ModelViewSet):
    serializer_class = CountrySerialier
    queryset = Country.objects.all()


class RegionViewSet(viewsets.ModelViewSet):
    serializer_class = RegionSerialier
    queryset = Region.objects.all()
