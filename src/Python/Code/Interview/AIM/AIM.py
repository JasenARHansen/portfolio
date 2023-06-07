#!/usr/bin/env python3
import math


class Point(object):
    """AIM Point class."""

    def __init__(self, x=0.0, y=0.0):
        self.x = float(x)
        self.y = float(y)

    def new_point(self, slope, distance, direction):
        # slope is infinite
        if slope == "MAX":
            x2 = self.x
            y2 = self.y + distance * direction
        # slope is 0
        elif slope == 0:
            x2 = self.x + distance * direction
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
        self.p1 = p1
        self.p2 = p2
        self.line_length = None
        self.line_slope = None
        self.line_perpendicular_slope = None
        self.direction = 1

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
        if rise == 0:
            if self.p2.x < self.p1.x:
                self.direction = -1
        if run == 0:
            self.line_slope = "MAX"
            if self.p2.y < self.p1.y:
                self.direction = -1
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
        print("""
              Given a set of distinct points in the x-y plane, find the number of distinct rectangles that can
               be formed from those points.
              Write a function find_rectangles that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique rectangles that can be using those points
               as corners. The rectangles do not need to be aligned with the x-y axes.
              For example, if points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3)}, then find_rectangles(points)
               should return 2. As illustrated in the figure here (https://imgur.com/a/ygK9wfB), there are two
                rectangles that can be formed from these points: the blue diamond {(-3, 0), (0, -3), (3, 0), (0, 3)}
                 and the green square {(0, 3), (3, 3), (3, 0), (0, 0)}.
              Make sure to give yourself enough time to implement a correct solution, then you can try to find
               solutions that have better asymptotic runtime.
              We are looking for production quality code, so please make sure your submission is clean and well
               documented. Also include any test cases you think would be helpful in validating correctness.""")

    @staticmethod
    def get_description_find_rectangles():
        print("""
              Given a set of distinct points in the x-y plane, find the number of distinct rectangles that can
               be formed from those points.
              Write a function find_rectangles that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique rectangles that can be using those points
               as corners. The rectangles do not need to be aligned with the x-y axes.
              Rectangles are more comples than squares since all 4 sides do not need to be the same length.  Due
               to that the code is more complex.""")

    @staticmethod
    def find_squares(points: set) -> list:
        """Find squares."""
        # No need to process points to remove duplicates. Sets do not allow duplicates
        # Convert set to list to allow itteration with index
        points_list = sorted(list(points), key=lambda x: (x[0], x[1]))
        # Define output set
        output = list()
        # Itterate over set to find rectangle start points.
        for p1index in range(len(points_list) - 1):
            for p2index in range(p1index + 1, len(points_list)):
                # Case 1: Aligned on x-y axis
                aligned = set()
                p1 = points_list[p1index]
                p4 = points_list[p2index]
                p2 = (p1[0], p4[1])
                p3 = (p4[0], p1[1])
                # I already know P1 and P4 are in the list so test for P2 and P3 only
                if all(value in points_list for value in [p2, p3]):
                    # Using add because if I initialize it looks like it allows duplicates
                    aligned.add(p1)
                    aligned.add(p1)
                    aligned.add(p2)
                    aligned.add(p3)
                    aligned.add(p4)
                    if len(aligned) == 4:
                        output.append(sorted(aligned, key=lambda x: (x[0], x[1])))
                # Case 2: Not aligned on x-y axis
                not_aligned = set()
                # X symetry
                if p1[0] == p4[0]:
                    center_distance = (abs(p1[1]) + abs(p4[1])) / 2
                    if p1[1] < p4[1]:
                        p2 = (p1[0] - center_distance, p1[1] + center_distance)
                        p3 = (p1[0] + center_distance, p1[1] + center_distance)
                    else:
                        p2 = (p1[0] - center_distance, p1[1] - center_distance)
                        p3 = (p1[0] + center_distance, p1[1] - center_distance)
                    if all(value in points_list for value in [p2, p3]):
                        # Using add because if I initialize it looks like it allows duplicates
                        not_aligned.add(p1)
                        not_aligned.add(p2)
                        not_aligned.add(p3)
                        not_aligned.add(p4)
                        if len(not_aligned) == 4:
                            output.append(sorted(not_aligned, key=lambda x: (x[0], x[1])))
                # Y symetry
                if p1[1] == p4[1]:
                    center_distance = (p1[0] + p4[0]) / 2
                    p2 = (p1[0] + center_distance, p1[1] + center_distance)
                    p3 = (p1[0] + center_distance, p1[1] - center_distance)
                    if all(value in points_list for value in [p2, p3]):
                        not_aligned.add(p1)
                        not_aligned.add(p2)
                        not_aligned.add(p3)
                        not_aligned.add(p4)
                        if len(not_aligned) == 4:
                            output.append(sorted(not_aligned, key=lambda x: (x[0], x[1])))
        b_set = set(tuple(x) for x in output)
        return [list(x) for x in b_set]

    @staticmethod
    def find_rectangles(points: set) -> list:
        """Find rectangles."""
        # No need to process points to remove duplicates. Sets do not allow duplicates
        # Convert set to list to allow itteration with index
        points_list = sorted(list(points), key=lambda x: (x[0], x[1]))
        # Define output set
        output = list()
        # Itterate over set to find rectangle start points.
        for p1index in range(len(points_list) - 2):
            for p2index in range(p1index + 1, len(points_list) - 1):
                # 2 points are defined to identify a line
                p1 = Point(points_list[p1index][0], points_list[p1index][1])
                p2 = Point(points_list[p2index][0], points_list[p2index][1])
                l1 = Line(p1, p2)
                # A third point is used to determine if a line perpendicular to l1 can be formed
                for p3index in range(p2index + 1, len(points_list)):
                    p3 = Point(points_list[p3index][0], points_list[p3index][1])
                    p4 = None
                    l2 = Line(p1, p3)
                    l3 = Line(p2, p3)
                    # Test
                    if l1.perpendicular_slope() == l2.slope():
                        # L1 perpendicular L2
                        p4 = p2.new_point(slope=l2.slope(), distance=l2.length(), direction=l2.direction)
                    elif l1.perpendicular_slope() == l3.slope():
                        # L1 perpendicular L3
                        p4 = p1.new_point(slope=l3.slope(), distance=l3.length(), direction=l3.direction)
                    elif l2.perpendicular_slope() == l3.slope():
                        # L2 perpendicular L3
                        p4 = p2.new_point(slope=l3.perpendicular_slope(), distance=l3.length(), direction=l3.direction)
                    if p4 and (p4.x, p4.y) in points_list:
                        point_set = (points_list[p1index], points_list[p2index], points_list[p3index], (p4.x, p4.y))
                        output.append(sorted(point_set, key=lambda x: (x[0], x[1])))
        b_set = set(tuple(x) for x in output)
        return [list(x) for x in b_set]
