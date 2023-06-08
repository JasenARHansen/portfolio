#!/usr/bin/env python3
import math


class Point(object):
    """AIM Point class."""

    def __init__(self, x=0.0, y=0.0):
        self.x = int(x) if int(x) == float(x) else float(x)
        self.y = int(y) if int(y) == float(y) else float(y)

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
        return Point(x=x2, y=y2)


class Line(object):
    """AIM Line class."""

    def __init__(self, p1: Point, p2: Point):
        self.p1 = p1 if p1.y <= p2.y else p2
        self.p2 = p2 if p1.y <= p2.y else p1
        self.line_length = None
        self.line_slope = None
        self.line_perpendicular_slope = None

    def length(self):
        if self.line_length:
            return self.line_length
        dist_x = abs(self.p2.x - self.p1.x)
        dist_y = abs(self.p2.y - self.p1.y)
        dist_x_squared = dist_x ** 2
        dist_y_squared = dist_y ** 2
        self.line_length = math.sqrt(dist_x_squared + dist_y_squared)
        return self.line_length

    def slope(self):
        if self.line_slope:
            return self.line_slope
        run = self.p2.x - self.p1.x
        rise = self.p2.y - self.p1.y
        if run == 0:
            self.line_slope = "MAX"
        else:
            self.line_slope = rise / run
        return self.line_slope

    def perpendicular_slope(self):
        if self.line_perpendicular_slope:
            return self.line_perpendicular_slope
        if not self.line_slope:
            self.slope()
        if self.line_slope == "MAX":
            self.line_perpendicular_slope = 0
        elif self.line_slope == 0:
            self.line_perpendicular_slope = "MAX"
        else:
            self.line_perpendicular_slope = -1 / self.line_slope
        return self.line_perpendicular_slope


# noinspection SpellCheckingInspection,PyTypeChecker
class AIM(object):
    """AIM main class."""

    @staticmethod
    def get_description_find_squares():
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
    def get_description_find_rectangles():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct rectangles
               that can be formed from those points.
              Write a function find_rectangles that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique rectangles that can be using those points
               as corners. The rectangles do not need to be aligned with the x-y axes.
              Rectangles are more comples than rectangles since all 4 sides do not need to be the same length.
              For example, if points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3)}, then find_rectangles(points)
               should return 2. As illustrated in the figure here (https://imgur.com/a/ygK9wfB), there are two
               rectangles that can be formed from these points: the blue diamond {(-3, 0), (0, -3), (3, 0), (0, 3)}
               and the green rectangle {(0, 3), (3, 3), (3, 0), (0, 0)}.
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
    def find_rectangles(points: set, square: bool = False) -> list:
        """Find rectangles."""
        # No need to process points to remove duplicates. Sets do not allow duplicates
        # Convert set to list to allow itteration with index and sort for processing simplicity
        points_list = sorted(list(points), key=lambda x: (x[0], x[1]))
        # Define output list
        output = list()
        # Itterate over list to find rectangle start points.
        for p1index in range(len(points_list) - 2):
            for p2index in range(p1index + 1, len(points_list) - 1):
                # 2 points are defined to identify a line
                p1 = Point(points_list[p1index][0], points_list[p1index][1])
                p2 = Point(points_list[p2index][0], points_list[p2index][1])
                l1 = Line(p1, p2)
                # A third point is used to determine if a line perpendicular to l1 can be formed
                for p3index in range(p2index + 1, len(points_list)):
                    p3 = Point(points_list[p3index][0], points_list[p3index][1])
                    l2 = Line(p1, p3)
                    l3 = Line(p2, p3)
                    # Test perpendicular
                    if l1.perpendicular_slope() == l2.slope():
                        # L1 perpendicular L2, P1 intersection
                        # P4 has 4 possible positions.  2 are equal and valid but 2 will make parallelagrams
                        # and are invalid
                        p4a = p2.new_point(slope=l2.slope(), distance=l2.length())
                        p4b = p2.new_point(slope=l2.slope(), distance=-l2.length())
                        l4 = Line(p2, p4a)
                        if l1.perpendicular_slope() == l4.slope():
                            l5 = Line(p3, p4a)
                            if l2.perpendicular_slope() == l5.slope() and (p4a.x, p4a.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4a.x, p4a.y))
                                if square and l2.length() == l5.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            l6 = Line(p3, p4b)
                            if l2.perpendicular_slope() == l6.slope() and (p4b.x, p4b.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4b.x, p4b.y))
                                if square and l2.length() == l6.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                        # Below is a complementry processing method, but it is redundant, so it is commented out.
                        """
                        p4c = p3.new_point(slope=l1.slope(), distance=l1.length())
                        p4d = p3.new_point(slope=l1.slope(), distance=-l1.length())
                        l4 = Line(p3, p4c)
                        if l2.perpendicular_slope() == l4.slope():
                            l5 = Line(p2, p4c)
                            if l2.perpendicular_slope() == l5.slope() and (p4c.x, p4c.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4c.x, p4c.y))
                                if square and l2.length() == l5.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            l6 = Line(p2, p4d)
                            if l2.perpendicular_slope() == l6.slope() and (p4d.x, p4d.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4d.x, p4d.y))
                                if square and l2.length() == l6.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                        """
                    elif l1.perpendicular_slope() == l3.slope():
                        # L1 perpendicular L3, P2 intersection
                        # P4 has 4 possible positions.  2 are equal and valid but 2 will make parallelagrams
                        # and are invalid
                        p4a = p1.new_point(slope=l3.slope(), distance=l3.length())
                        p4b = p1.new_point(slope=l3.slope(), distance=-l3.length())
                        l4 = Line(p1, p4a)
                        if l1.perpendicular_slope() == l4.slope():
                            l5 = Line(p3, p4a)
                            if l3.perpendicular_slope() == l5.slope() and (p4a.x, p4a.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4a.x, p4a.y))
                                if square and l3.length() == l5.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            l6 = Line(p3, p4b)
                            if l3.perpendicular_slope() == l6.slope() and (p4b.x, p4b.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4b.x, p4b.y))
                                if square and l3.length() == l6.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                        # Below is a complementry processing method, but it is redundant, so it is commented out.
                        """
                        p4c = p3.new_point(slope=l1.slope(), distance=l1.length())
                        p4d = p3.new_point(slope=l1.slope(), distance=-l1.length())
                        l4 = Line(p3, p4c)
                        if l3.perpendicular_slope() == l4.slope():
                            l5 = Line(p1, p4c)
                            if l1.perpendicular_slope() == l5.slope() and (p4c.x, p4c.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4c.x, p4c.y))
                                if square and l1.length() == l5.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            l6 = Line(p1, p4d)
                            if l1.perpendicular_slope() == l6.slope() and (p4d.x, p4d.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4d.x, p4d.y))
                                if square and l1.length() == l6.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                
                        """
                    elif l2.perpendicular_slope() == l3.slope():
                        # L2 perpendicular L3, P3 intersection
                        # P4 has 4 possible positions.  2 are equal and valid but 2 will make parallelagrams
                        # and are invalid
                        p4a = p1.new_point(slope=l3.slope(), distance=l3.length())
                        p4b = p1.new_point(slope=l3.slope(), distance=-l3.length())
                        l4 = Line(p1, p4a)
                        if l2.perpendicular_slope() == l4.slope():
                            l5 = Line(p2, p4a)
                            if l3.perpendicular_slope() == l5.slope() and (p4a.x, p4a.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4a.x, p4a.y))
                                if square and l3.length() == l5.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            l6 = Line(p2, p4b)
                            if l3.perpendicular_slope() == l6.slope() and (p4b.x, p4b.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4b.x, p4b.y))
                                if square and l3.length() == l6.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                        # Below is a complementry processing method, but it is redundant, so it is commented out.
                        """
                        p4c = p2.new_point(slope=l2.slope(), distance=l2.length())
                        p4d = p2.new_point(slope=l2.slope(), distance=-l2.length())
                        l4 = Line(p2, p4c)
                        if l3.perpendicular_slope() == l4.slope():
                            l5 = Line(p1, p4c)
                            if l1.perpendicular_slope() == l5.slope() and (p4c.x, p4c.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4c.x, p4c.y))
                                if square and l1.length() == l5.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            l6 = Line(p1, p4d)
                            if l1.perpendicular_slope() == l6.slope() and (p4d.x, p4d.y) in points_list:
                                point_set = (points_list[p1index], points_list[p2index], points_list[p3index],
                                             (p4d.x, p4d.y))
                                if square and l1.length() == l6.length():
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                                elif not square:
                                    output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
                        """
        # Sort values and eliminate duplicates
        return [list(x) for x in set(tuple(x) for x in output)]
