#!/usr/bin/env python3
from datetime import datetime

import requests  # Remember to pip install requests


# noinspection PyPep8Naming
class RootThreshold(object):
    """Question1 main class."""

    @staticmethod
    def get_description():
        print("""2: REST API: Root Threshold in IOT Devices
    A REST API contains information about a collection of IoT devices.
    Given a string statusQuery, numerical threshold value, and date in format MM-YYYY,
     query the API to get a list of devices.
      Return the total number of devices that:
        1: were added to the collection during the given month and year
        2: have a root threshold > threshold
    Make an HTTP GET request to
     https://jsonmock.hackerrank.com/api/iot_devices/search?status=<statusQuery>&page=<pageNumber>.
    It will return all items with statusQuery as a substring of their status.
    Be sure to grab all the pages.
    The response is a JSON with the following 5 fields:
        page: The current page
        per_page: The maximum number of devices returned per page
        total: The total number of devices
        total_pages: The total number of pages
        data: An array of objects containing information
    Each device object has the following schema:
        id: The unique ID of the device
        timestamp: The timestamp when the device was added to the collection, in UTC milliseconds
        status: The status of the device
        operatingParams: an object containing operating parameters of the device
        asset: an object containing information about the asset of the device
        parent: Optional. The object containing information about the parent of the device
    The operating parameters object has the following schema:
        rotorSpeed: The rotor speed of the device
        slack: The slack in the device
        rootThreshold: The root threshold for the device
    The asset object has the following schema:
        id: The unique ID of the asset
        alias: The alias for the asset
    The parent object has the following schema:
        id: The unique ID of the parent of the asset
        alias: The alias for the parent of the asset
    Function Description :
        Complete the function numDevices in the editor below.
            numDevices has the following parameter(s):
                string statusQuery: the status substring to query
                int threshold: the threshold value
                string dateStr: in format MM-YYYY, the month and the year to query for
        Returns:
            int: the number of matching devices
        Note: Please review the header in the code stub to see available libraries for API requests in the selected language.
    Required libraries can be imported in order to solve the question.
     heck our full list of supported libraries at https://www.hackerrank.com/environment.
    Input Format For Custom Testing
        In the first line, there is a string statusQuery.
        In the second line, there is an integer threshold.
        In the third line, there is a string dateStr.
    Sample Case 0:
        Sample Input For Custom Testing:
            STOPPED
            45
            04-2019
    Sample Output:
        3
    Explanation:
        The status query is "STOPPED", the threshold value is 45 and we are interested in the devices added
         to the collection in April 2019.
         There are a total of 3 devices.""")

    #
    # Complete the 'numDevices' function below.
    #
    # The function is expected to return an INTEGER.
    # The function accepts following parameters:
    #  1. STRING statusQuery
    #  2. INTEGER threshold
    #  3. STRING dateStr
    #
    # https://jsonmock.hackerrank.com/api/iot_devices/search?status=<statusQuery>&page=<pageNumber>
    #

    @staticmethod
    def numDevices(statusQuery: str, threshold: int, dateStr: str):
        total = 0
        date = dateStr.split("-")
        target_year = int(date[1])
        target_month = int(date[0])
        template = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=<statusQuery>&page=<pageNumber>"
        template = template.replace("<statusQuery>", statusQuery)
        page = 0
        while True:
            url = template.replace("<pageNumber>", str(page))
            page += 1
            response = requests.get(url)
            json = response.json()
            if len(json['data']) == 0:
                # no data on page
                break
            else:
                # process data returned
                for element in json['data']:
                    timestamp = element['timestamp']
                    # Data is stored with too much precision so truncating last 3 digits
                    timestamp = int(timestamp / 1000)
                    dt_object = datetime.fromtimestamp(timestamp)
                    if target_year == dt_object.year and target_month == dt_object.month:
                        operatingThreshold = element['operatingParams']['rootThreshold']
                        if operatingThreshold > threshold:
                            total += 1
        return total
