import yaml
import io

if __name__ == "__main__":
    data_loaded = None

    # Read YAML file
    with open("locations.yaml", 'r') as stream:
        data_loaded = yaml.safe_load(stream)

    with open("location_inserts.sql", "w") as stream:
        # Clear File
        stream.truncate(0)

        # Boilerplate
        stream.write('USE `FreeFoodFinderDB`;\n')
        stream.write('describe dietary_restriction;\ndescribe location;\n')
        stream.write('INSERT INTO location VALUES \n')

        # Write inserts
        for i, loc in enumerate(data_loaded['locations']):
            stream.write('    (DEFAULT, "{}", {}, {}, {})'.format(loc['name'], loc['lat'], loc['lon'], loc['outdoor']))
            stream.write(";" if i == len(data_loaded['locations']) - 1 else ",\n")
