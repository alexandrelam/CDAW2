import graphene
from graphene import relay
from graphene_django import DjangoObjectType
from graphene_django.filter import DjangoFilterConnectionField
from weather.models import Country, Region


class CountryNode(DjangoObjectType):
    class Meta:
        model = Country
        filter_fields = {
            'name': ['exact', 'icontains', 'istartswith'],
        }
        interfaces = (relay.Node, )


class RegionNode(DjangoObjectType):
    class Meta:
        model = Region
        filter_fields = {
            'name': ['exact', 'icontains', 'istartswith'],
            'temperature': ['exact']
        }
        interfaces = (relay.Node, )
        interfaces = (relay.Node, )


class Query(graphene.ObjectType):
    country = relay.Node.Field(CountryNode)
    all_countries = DjangoFilterConnectionField(CountryNode)

    region = relay.Node.Field(RegionNode)
    all_regions = DjangoFilterConnectionField(RegionNode)


schema = graphene.Schema(query=Query)
