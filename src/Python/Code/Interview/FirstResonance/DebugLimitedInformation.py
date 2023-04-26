#!/usr/bin/env python3

class DebugLimitedInformation(object):
    """Test the elements visible at the root of the file."""

    @staticmethod
    def get_description():
        print("""
                Debugging a problem with limited information
                  This scenario has a time limit. If you start the next scenario
                  before completing this one, this scenario's timer will continue
                  running and the timer for the next scenario will start. So we
                  recommend staying on this scenario until you are finished with it.""")
