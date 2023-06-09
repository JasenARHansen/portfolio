#!/usr/bin/env python3
import math


class Point(object):
    """AIM Point class."""

    def __init__(self, point=(0.0, 0.0)):
        self.x = int(point[0]) if int(point[0]) == float(point[0]) else float(point[0])
        self.y = int(point[1]) if int(point[1]) == float(point[1]) else float(point[1])

    def new_point(self, slope, distance):
        # slope is infinite
        if slope == "MAX":
            x2 = self.x
            y2 = self.y + distance
        # slope is 0
        elif slope == 0:
            x2 = self.x + distance
            y2 = self.y
        else:
            dx = round((distance / math.sqrt(1 + (slope ** 2))), 2)
            dy = slope * dx
            x2 = self.x + dx
            y2 = self.y + dy
        return Point(point=(x2, y2))

    def get_coordinates(self):
        return self.x, self.y


class Line(object):
    """AIM Line class."""

    def __init__(self, p1: Point, p2: Point):
        self.p1 = p1
        self.p2 = p2
        self._line_length = None
        self._line_slope = None
        self._perpendicular_slope = None

    def length(self):
        if self._line_length:
            return self._line_length
        dist_x = abs(self.p2.x - self.p1.x)
        dist_y = abs(self.p2.y - self.p1.y)
        dist_x_squared = dist_x ** 2
        dist_y_squared = dist_y ** 2
        self._line_length = math.sqrt(dist_x_squared + dist_y_squared)
        return self._line_length

    def slope(self):
        if self._line_slope:
            return self._line_slope
        run = self.p2.x - self.p1.x
        rise = self.p2.y - self.p1.y
        if run == 0:
            self._line_slope = "MAX"
        else:
            self._line_slope = rise / run
        return self._line_slope

    def is_perpendicular(self, line):
        if not self._line_slope:
            self.slope()
        if not self._perpendicular_slope:
            if self._line_slope == "MAX":
                self._perpendicular_slope = 0
            elif self._line_slope == 0:
                self._perpendicular_slope = "MAX"
            else:
                self._perpendicular_slope = -1 / self._line_slope
        if self._perpendicular_slope == line.slope():
            return True
        return False


# noinspection SpellCheckingInspection,PyTypeChecker
class AIM(object):
    """AIM main class."""

    @staticmethod
    def help_find_squares():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct squares
               that can be formed from those points.
              Write a function find_squares that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique squares that can be using those points
               as corners. The squares do not need to be aligned with the x-y axes.
              For example, if points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3)}, then find_squares(points)
               should return 2. As illustrated in the figure here (https://imgur.com/a/ygK9wfB), there are two
               squares that can be formed from these points: the blue diamond {(-3, 0), (0, -3), (3, 0), (0, 3)}
               and the green square {(0, 3), (3, 3), (3, 0), (0, 0)}.
              Make sure to give yourself enough time to implement a correct solution, then you can try to find
               solutions that have better asymptotic runtime.
              We are looking for production quality code, so please make sure your submission is clean and well
               documented. Also include any test cases you think would be helpful in validating correctness.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_squares(points: set) -> list:
        """Find squares."""
        return AIM.find_rectangles(points=points, square=True)

    @staticmethod
    def help_find_rectangles():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct rectangles
               that can be formed from those points.
              Write a function find_rectangles that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique rectangles that can be using those points
               as corners. The rectangles do not need to be aligned with the x-y axes.
              Rectangles are more comples than rectangles since all 4 sides do not need to be the same length.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_rectangles(points: set, square: bool = False) -> list:
        """Find rectangles."""
        # No need to process points to remove duplicates. Sets do not allow duplicates
        # Convert set to list to allow iteration with index and sort for processing simplicity
        # Note: If this is not sorted there can be orderings that cause porcessing failures
        points_list = sorted(list(points), key=lambda x: (x[0], x[1]))
        # Define output list
        output = list()
        # Iterate over list to find rectangle start points.
        for p1index in range(len(points_list) - 2):
            for p2index in range(p1index + 1, len(points_list) - 1):
                # 2 points are defined to identify a line
                p1 = Point(point=points_list[p1index])
                p2 = Point(point=points_list[p2index])
                l1 = Line(p1=p1, p2=p2)
                # A third point is used to determine if a line perpendicular to l1 can be formed
                for p3index in range(p2index + 1, len(points_list)):
                    p3 = Point(point=points_list[p3index])
                    l2 = Line(p1=p2, p2=p3)
                    # Test to see if l1 is perpendicularto l2 interseccting at p2
                    if l1.is_perpendicular(line=l2):
                        # P4 has 2 possible positions, 1 valid and are invalid
                        # Test first posibility
                        p4a = p3.new_point(slope=l1.slope(), distance=l1.length())
                        l4 = Line(p1=p1, p2=p4a)
                        # Test to see if l1 is perpendicular to l4 and verify constructed point is in points list
                        if l1.is_perpendicular(line=l4) and p4a.get_coordinates() in points_list:
                            point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                         p4a.get_coordinates())
                            # If testing for a square the 2 perpendicular lines must be equal length
                            if square and l1.length() == l4.length():
                                output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            elif not square:
                                output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                        # Test second posibility
                        p4b = p3.new_point(slope=l1.slope(), distance=-l1.length())
                        l4 = Line(p1=p1, p2=p4b)
                        # Test to see if l1 is perpendicular to l4 and verify constructed point is in points list
                        if l1.is_perpendicular(line=l4) and p4b.get_coordinates() in points_list:
                            point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                         p4b.get_coordinates())
                            # If testing for a square the 2 perpendicular lines must be equal length
                            if square and l1.length() == l4.length():
                                output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            elif not square:
                                output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
        # Sort values and eliminate duplicates
        return [list(x) for x in set(tuple(x) for x in output)]

    @staticmethod
    def help_find_triangles():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangles(points: set, isosceles: bool = False, equilateral: bool = False) -> list:
        """Find triangles."""
        # No need to process points to remove duplicates. Sets do not allow duplicates
        # Convert set to list to allow iteration with index and sort for processing simplicity
        points_list = sorted(list(points), key=lambda x: (x[0], x[1]))
        # Define output list
        output = list()
        # Iterate over list to find rectangle start points.
        for p1index in range(len(points_list) - 2):
            for p2index in range(p1index + 1, len(points_list) - 1):
                # 2 points are defined to identify line 1
                p1 = Point(point=points_list[p1index])
                p2 = Point(point=points_list[p2index])
                l1 = Line(p1=p1, p2=p2)
                # A third point is used to find line 2 and 3
                for p3index in range(p2index + 1, len(points_list)):
                    p3 = Point(point=points_list[p3index])
                    l2 = Line(p1=p1, p2=p3)
                    l3 = Line(p1=p2, p2=p3)
                    # Verify that the 3 points are not collinear.  To do this the slopes of only 2 lines
                    # must be tested
                    if l1.slope() == l2.slope():
                        continue
                    point_set = (points_list[p1index], points_list[p2index], points_list[p3index])
                    if isosceles or equilateral:
                        length_set = set()
                        length_set.add(round(l1.length()))
                        length_set.add(round(l2.length()))
                        length_set.add(round(l3.length()))
                        # equilateral triangles have 3 sides that are equal in length
                        if equilateral and len(length_set) == 1:
                            output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                        # isosceles triangles have 2 sides that are equal in length
                        elif isosceles and len(length_set) <= 2:
                            output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    else:
                        output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
        # Sort values and eliminate duplicates
        return [list(x) for x in set(tuple(x) for x in output)]

    @staticmethod
    def help_find_triangles_isosceles():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              Isosceles triangles are defined as having 2 sides of identical length.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangles_isosceles(points: set) -> list:
        """Find isosceles triangles."""
        return AIM.find_triangles(points=points, isosceles=True)

    @staticmethod
    def help_find_triangles_equilateral():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              Equilateral triangles are defined as having 3 sides of identical length.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangles_equilateral(points: set) -> list:
        """Find equilateral triangles."""
        return AIM.find_triangles(points=points, equilateral=True)
