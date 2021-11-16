from bs4 import BeautifulSoup
from yaml import load, dump
try:
    from yaml import CLoader as Loader, CDumper as Dumper
except ImportError:
    from yaml import Loader, Dumper

ROW_BLDG_NAME_INDEX = 5
ROW_ADDRESS_INDEX = 7
ROW_LAT = 16
ROW_LON = 17

if __name__ == '__main__':


    locations = []
    with open('table.html', 'r') as stream:
        soup = BeautifulSoup(stream, "html.parser")
        rows = soup.find_all("div", {"class": "dgrid-row"})
        for row in rows:
            entries = row.find_all("td")
            name = entries[ROW_BLDG_NAME_INDEX].find('div').text.title()
            address = entries[ROW_ADDRESS_INDEX].find('div').text.title()
            lat = entries[ROW_LAT].find('div').text
            lon = entries[ROW_LON].find('div').text
            locations.append({
                'name': name,
                'lat': lat,
                'lon': lon,
                'address': address,
                'outdoor': False
            })
    with open('locations.yaml', 'w') as stream:
        stream.write(dump({'locations': locations}))