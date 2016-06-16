db.continents.drop()
db.continents.save( {_id : 1, name : 'Africa'} );
db.continents.save( {_id : 2, name : 'Asia'} );
db.continents.save( {_id : 3, name : 'Europe'} );
db.continents.save( {_id : 4, name : 'North America'} );
db.continents.save( {_id : 5, name : 'South America'} );
db.continents.save( {_id : 6, name : 'Australia'} );
db.continents.save( {_id : 7, name : 'Antarctica'} );

db.countries.drop()
db.countries.save( { "name" : "Australia" , "area" : 2966200 , "population" : 21884000 , "continent" : { "_id" : 6 , "name" : "Australia"}} );
db.countries.save( { "name" : "Gabon" , "area" : 103347 , "population" : 1475000 , "continent" : { "_id" : 1 , "name" : "Africa"}} );
db.countries.save( { "name" : "Gambia" , "area" : 4361 , "population" : 1705000 , "continent" : { "_id" : 1 , "name" : "Africa"}} );
db.countries.save( { "name" : "Georgia" , "area" : 26900 , "population" : 4382100 , "continent" : { "_id" : 3 , "name" : "Europe"}} );
db.countries.save( { "name" : "Germany" , "area" : 137847 , "population" : 82046000 , "continent" : { "_id" : 3 , "name" : "Europe"}} );
db.countries.save( { "name" : "Ghana" , "area" : 92098 , "population" : 23837000 , "continent" : { "_id" : 1 , "name" : "Africa"}} );
db.countries.save( { "name" : "Greece" , "area" : 50949 , "population" : 11257285 , "continent" : { "_id" : 3 , "name" : "Europe"}} );
db.countries.save( { "name" : "Japan" , "area" : 145925 , "population" : 126659683 , "continent" : { "_id" : 2 , "name" : "Asia"}} );
db.countries.save( { "name" : "New Zealand" , "area" : 104454 , "population" : 4320300 , "continent" : { "_id" : 6 , "name" : "Australia"}} );
db.countries.save( { "name" : "Serbia" , "area" : 34116 , "population" : 7120666 , "continent" : { "_id" : 3 , "name" : "Europe"}} );
db.countries.save( { "name" : "Vietnam" , "area" : 128565 , "population" : 90388000 , "continent" : { "_id" : 2 , "name" : "Asia"}} );

db.megacities.drop();
db.megacities.save( {name : 'Argentina', cities : [ {name : 'Buenos Aires', population : 14300000, growth : 1.00 }]} );
db.megacities.save( {name : 'Bangladesh', cities : [ {name : 'Dhaka', population : 14000000, growth : 4.10}]} );
db.megacities.save( {name : 'Brazil', cities : [ {name : 'S?o Paulo', population : 21100000, growth : 1.40}, {name : 'Rio de Janeiro', population : 12700000}]} );
db.megacities.save( {name : 'China', cities : [ {name : 'Shanghai', population : 25300000, growth : 2.20}, {name : 'Beijing', population : 16400000, growth : 2.70}, {name : 'Tianjin', population : 12938224}, {name : 'Guangzhou', population : 12700800, growth : 4.00}, {name : 'Shenzhen', population : 12506000}]} );
db.megacities.save( {name : 'Egypt', cities : [ {name : 'Cairo', population : 19439541, growth : 2.60}]} );
db.megacities.save( {name : 'France', cities : [ {name : 'Paris', population : 10600000, growth : 1.00}]} );
db.megacities.save( {name : 'India', cities : [ {name : 'Delhi', population : 23000000, growth : 4.60}, {name : 'Mumbai', population : 20800000, growth : 2.90}, {name : 'Kolkata', population : 15700000, growth : 2.00}]} );
db.megacities.save( {name : 'Indonesia', cities : [ {name : 'Jakarta', population : 28019545, growth : 2.20}]} );
db.megacities.save( {name : 'Iran', cities : [ {name : 'Tehran', population : 13500000, growth : 2.60}]} );
db.megacities.save( {name : 'Japan', cities : [ {name : 'Tokyo', population : 35682460, growth : 0.60}, {name : 'Osaka', population : 16800000, growth : 0.15}]} );
db.megacities.save( {name : 'Mexico', cities : [ {name : 'Mexico City', population : 23200000, growth : 2.00}]} );
db.megacities.save( {name : 'Nigeria', cities : [ {name : 'Lagos', population : 12700000, growth : 3.20}]} );
db.megacities.save( {name : 'Pakistan', cities : [ {name : 'Karachi', population : 23500000, growth : 4.90}, {name : 'Lahore', population : 12500000, growth : 2.00}]} );
db.megacities.save( {name : 'Philippines', cities : [ {name : 'Manila', population : 20700000, growth : 2.50}]} );
db.megacities.save( {name : 'Russia', cities : [ {name : 'Moscow', population : 16200000, growth : 0.20}]} );
db.megacities.save( {name : 'South Korea', cities : [ {name : 'Seoul', population : 25600000, growth : 1.40}]} );
db.megacities.save( {name : 'Thailand', cities : [ {name : 'Bangkok', population : 14565547, growth : 0.90}]} );
db.megacities.save( {name : 'Turkey', cities : [ {name : 'Istanbul', population : 13850000, growth : 2.80}]} );
db.megacities.save( {name : 'United Kingdom', cities : [ {name : 'London', population : 12600000, growth : 0.70}]} );
db.megacities.save( {name : 'United States', cities : [ {name : 'New York', population : 19831858, growth : 0.30}, {name : 'Los Angeles', population : 13052921, growth : 1.11}]} );
