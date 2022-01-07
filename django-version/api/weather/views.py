from weather.serializers import CountrySerialier, RegionSerialier
from weather.models import Country, Region
from rest_framework import viewsets
from rest_framework.permissions import IsAuthenticated


# Create your views here.

class CountryViewSet(viewsets.ModelViewSet):
    """
    Returns a list of all countries in the system

    For more details on how accounts are activated please [see here][ref].

    [ref]: http://example.com/activating-accounts
    """
    permission_classes = [IsAuthenticated]
    serializer_class = CountrySerialier
    queryset = Country.objects.all()


class RegionViewSet(viewsets.ModelViewSet):
    serializer_class = RegionSerialier
    queryset = Region.objects.all()
