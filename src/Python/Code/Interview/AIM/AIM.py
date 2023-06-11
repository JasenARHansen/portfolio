#!/usr/bin/env python3
import math
from functools import reduce


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
            dx = round((distance / math.sqrt(1 + (slope ** 2))), 5)
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

    def is_parallel(self, line2):
        if not self._line_slope:
            self.slope()
        if self._line_slope == line2.slope():
            return True
        return False

    def is_perpendicular(self, line2):
        if not self._line_slope:
            self.slope()
        if not self._perpendicular_slope:
            if self._line_slope == "MAX":
                self._perpendicular_slope = 0
            elif self._line_slope == 0:
                self._perpendicular_slope = "MAX"
            else:
                self._perpendicular_slope = -1 / self._line_slope
        if self._perpendicular_slope == line2.slope():
            return True
        return False

    def length_equal(self, line2):
        if self.length() == line2.length():
            return True
        return False

    def slope_equal(self, line2):
        if self.slope() == line2.slope():
            return True
        return False

    def get_angle(self, line2):
        # https://stackoverflow.com/questions/62195081/calculate-specific-angle-between-two-lines
        # Get directional vectors
        d1 = (self.p2.x - self.p1.x, self.p2.y - self.p1.y)
        if self.p1.get_coordinates() == line2.p1.get_coordinates():
            d2 = (line2.p2.x - line2.p1.x, line2.p2.y - line2.p1.y)
        else:
            d2 = (line2.p1.x - line2.p2.x, line2.p1.y - line2.p2.y)
        # Compute dot product
        p = d1[0] * d2[0] + d1[1] * d2[1]
        # Compute norms
        n1 = round((math.sqrt(d1[0] * d1[0] + d1[1] * d1[1])), 5)
        n2 = round((math.sqrt(d2[0] * d2[0] + d2[1] * d2[1])), 5)
        # Rounding error causes this to go out of valid range
        base = (p / (n1 * n2))
        if abs(base) > 1:
            base = round(base, 4)
        # Compute angle
        ang = math.acos(base)
        # Convert to degrees if you want
        return round(math.degrees(ang), 5)


# noinspection SpellCheckingInspection,PyTypeChecker,PySetFunctionToLiteral
class AIM(object):
    """AIM main class."""

    @staticmethod
    def find_quadrilateral(points: set, **kwargs) -> list:
        """Find quadrilateral."""
        # No need to process points to remove duplicates. Sets do not allow duplicates
        """ Note: Shape definiopns: https://www.skillsyouneed.com/num/polygons.html
            Note: An issue was noted when not sorting the list with "sorted(list(points), key=lambda x: (x[0], x[1]))".
                There were orders of points that did not allow some items to be detected. This was fixed by
                 changing the inner 2 "for index" loops to both trigger off of the "p1index + 1" values to ensure
                 propper processing.
                This exposed a second issue where the point_set allowed duplicate values to be present. This caused
                 items to be listed that were invalid. To correct this error and remove duplicated, the set was
                 converted to a list and then back to a set.
                Both of these issues were not seen in testing with the sorted list, but I am not confident that
                 it was guarenteed to not have other orderings that still caused the issue. The implemented code
                 looks less elagant, but I feel it is safer."""

        def in_and_true(shape: str = None):
            if shape is not None and kwargs:
                if shape in kwargs:
                    return kwargs.get(shape)
            return False

        # Convert set to list to allow iteration with index and sort for processing simplicity
        points_list = list(points)
        # Define output dictionary
        output_dictionary = {}
        for arg in kwargs:
            output_dictionary[arg] = list()
        # Iterate over list to find rectangle start points.
        for p1index in range(len(points_list)):
            for p2index in range(p1index + 1, len(points_list)):
                # 2 points are defined to identify a line
                p1 = Point(point=points_list[p1index])
                p2 = Point(point=points_list[p2index])
                # The first 2 points are used to generate the first side
                l1 = Line(p1=p1, p2=p2)
                # A third point is used to generate the 2nd side
                for p3index in range(p1index + 1, len(points_list)):
                    p3 = Point(point=points_list[p3index])
                    l2 = Line(p1=p2, p2=p3)
                    # These
                    if any([in_and_true(shape) for shape in ["square", "rectangle", "parallelogram", "rhombus"]]):
                        # For the regualr quadrilaterals that have 2 sets of parallel sides, P4 has 2 possible
                        # positions, 1 valid and are invalid
                        p4a = p3.new_point(slope=l1.slope(), distance=l1.length())
                        p4b = p3.new_point(slope=l1.slope(), distance=-l1.length())
                        possible_points = [p4a, p4b]
                        # Itterate over possible_points to generate valid quadrilateral
                        for point in possible_points:
                            # These are the remaining 2 potential sides of the quadrilateral
                            l3 = Line(p1=p3, p2=point)
                            l4 = Line(p1=point, p2=p1)
                            if point.get_coordinates() in points_list:
                                point_set = {points_list[p1index], points_list[p2index], points_list[p3index],
                                             point.get_coordinates()}
                                # A quadrilateral must have 4 points and not have adjacent lines be collinear
                                if len(point_set) != 4:
                                    continue
                                # The sum of the inner angles of a quadrilateral must be 360 degrees
                                angle_list = [round(l1.get_angle(line2=l2), 5), round(l2.get_angle(line2=l3), 5),
                                              round(l3.get_angle(line2=l4), 5), round(l4.get_angle(line2=l1), 5)]
                                # A quadrilateral requires the sum of the inner angles to be 360
                                if 360 != round(reduce(lambda x, y: x + y, angle_list), 3):
                                    continue
                                # If the angle between any 2 lines in 180,  then this will be colinnear
                                if 180 in angle_list:
                                    continue
                                angle_set = set(angle_list)
                                length_set = {round(l1.length(), 5), round(l2.length(), 5), round(l3.length(), 5),
                                              round(l4.length(), 5)}
                                # Determine the type of quadrilateral to process.
                                if all([in_and_true("square"), len(angle_set) == 1, len(length_set) == 1]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("square").append(
                                        sorted(point_set, key=lambda x: (x[0], x[1])))
                                if all([in_and_true("rectangle"), len(angle_set) == 1, len(length_set) <= 2]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("rectangle").append(
                                        sorted(point_set, key=lambda x: (x[0], x[1])))
                                if all([in_and_true("parallelogram"), len(angle_set) <= 2, len(length_set) <= 2]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("parallelogram").append(
                                        sorted(point_set, key=lambda x: (x[0], x[1])))
                                if all([in_and_true("rhombus"), len(angle_set) <= 2, len(length_set) == 1]):
                                    # If valid quadrilateral detected, append to output
                                    output_dictionary.get("rhombus").append(
                                        sorted(point_set, key=lambda x: (x[0], x[1])))
                    if any([in_and_true(shape) for shape in ["trapezoid", "isosceles_trapezoid", "kite", "irregular"]]):
                        for p4index in range(p1index + 1, len(points_list)):
                            p4 = Point(point=points_list[p4index])
                            point_set = {points_list[p1index], points_list[p2index], points_list[p3index],
                                         points_list[p4index]}
                            # These are the remaining 2 potential sides of the quadrilateral
                            l3 = Line(p1=p3, p2=p4)
                            l4 = Line(p1=p4, p2=p1)
                            # A quadrilateral must have 4 sides and no lines be collinear
                            if any([len(point_set) != 4, l1.is_parallel(l2), l2.is_parallel(l3), l3.is_parallel(l4),
                                    l4.is_parallel(l1)]):
                                continue
                            # The sum of the inner angles of a quadrilateral must be 360 degrees
                            angle_list = [round(l1.get_angle(line2=l2), 5), round(l2.get_angle(line2=l3), 5),
                                          round(l3.get_angle(line2=l4), 5), round(l4.get_angle(line2=l1), 5)]
                            # A quadrilateral requires the sum of the inner angles to be 360
                            if 360 != round(reduce(lambda x, y: x + y, angle_list), 3):
                                continue
                            # If the angle between any 2 lines in 180,  then this will be colinnear
                            if 180 in angle_list:
                                continue
                            angle_set = set(angle_list)
                            length_set = {round(l1.length(), 5), round(l2.length(), 5), round(l3.length(), 5),
                                          round(l4.length(), 5)}
                            if all([in_and_true("trapezoid"), any([
                                all([l1.is_parallel(l3), l1.get_angle(l2) != l1.get_angle(l4),
                                     any([all([l1.get_angle(l4) <= 90, l1.get_angle(l2) <= 90]),
                                          all([l1.get_angle(l4) >= 90, l1.get_angle(l2) >= 90])])]),
                                all([l2.is_parallel(l4), l2.get_angle(l3) != l2.get_angle(l1),
                                     any([all([l2.get_angle(l3) <= 90, l2.get_angle(l1) <= 90]),
                                          all([l2.get_angle(l3) >= 90, l2.get_angle(l1) >= 90])])])])]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("trapezoid").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            if all([in_and_true("isosceles_trapezoid"), len(angle_set) == 2,
                                    any([all([l1.is_parallel(l3),
                                              any([all([l1.get_angle(l4) <= 90, l1.get_angle(l2) <= 90]),
                                                   all([l1.get_angle(l4) >= 90, l1.get_angle(l2) >= 90])])]),
                                         all([l2.is_parallel(l4),
                                              any([all([l2.get_angle(l3) <= 90, l2.get_angle(l1) <= 90]),
                                                   all([l2.get_angle(l3) >= 90, l2.get_angle(l1) >= 90])])])
                                         ])
                                    ]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("isosceles_trapezoid").append(
                                    sorted(point_set, key=lambda x: (x[0], x[1])))
                            if all([in_and_true("kite"), len(set(angle_set)) <= 3, len(length_set) <= 2,
                                    any([l1.length_equal(l2), l1.length_equal(l4)])]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("kite").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                            if all([in_and_true("irregular"), len(angle_set) == 4, len(length_set) == 4]):
                                # If valid quadrilateral detected, append to output
                                output_dictionary.get("irregular").append(sorted(point_set, key=lambda x: (x[0], x[1])))
        # Sort values and eliminate duplicates
        for key in output_dictionary:
            output_dictionary[key] = [list(x) for x in set(tuple(x) for x in output_dictionary.get(key))]
        return output_dictionary

    @staticmethod
    def find_irregular_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               irregular quadrilaterals that can be formed from those points.
              Irregular quadrilateral are defined a four-sided shape where no sides are equal in length and no
               internal angles are the same. All internal angles still add up to 360°, as with all other
                regular quadrilaterals.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_irregular(points: set) -> list:
        """Find irregular."""
        results = AIM.find_quadrilateral(points=points, irregular=True)
        return results["irregular"]

    @staticmethod
    def find_kite_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               kite quadrilaterals that can be formed from those points.
              Kites are defined as having 4 sides, formed with 4 points. Two pairs of adjacent sides are of
               equal length; the shape has an axis of symmetry.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_kite(points: set) -> list:
        """Find kite."""
        results = AIM.find_quadrilateral(points=points, kite=True)
        return results["kite"]

    @staticmethod
    def find_isosceles_trapezoid_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               isosceles trapezoid quadrilaterals that can be formed from those points.
              Isosceles trapezoid are defined as having 4 sides, formed with 4 points. Two sides are parallel and
               base angles are equal, meaning that non-parallel sides are also equal in length.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_isosceles_trapezoid(points: set) -> list:
        """Find isosceles trapezoid."""
        results = AIM.find_quadrilateral(points=points, isosceles_trapezoid=True)
        return results["isosceles_trapezoid"]

    @staticmethod
    def find_trapezoid_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               trapezoid quadrilaterals that can be formed from those points.
              Trapezoid are defined as having 4 sides, formed with 4 points. Two sides are parallel, but the other
               two sides are not. Side lengths and angles are not equal.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_trapezoid(points: set) -> list:
        """Find trapezoid."""
        results = AIM.find_quadrilateral(points=points, trapezoid=True)
        return results["trapezoid"]

    @staticmethod
    def find_parallelogram_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               parallelograms that can be formed from those points.
              Parallelograms are defined as having 4 sides, formed with 4 points. Opposite sides are parallel,
               opposite sides are equal in length, opposite angles are equal.
              Write a function find_parallelogram that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique parallelograms that can be using those points
               as corners. The parallelograms do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_parallelogram(points: set) -> list:
        """Find parallelogram."""
        results = AIM.find_quadrilateral(points=points, parallelogram=True)
        return results["parallelogram"]

    @staticmethod
    def find_rhombus_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct
               rhombuses that can be formed from those points.
              Rhombuses are defined as having a special type of parallelogram in which all four sides are the
               same length, like a square that has been squashed sideways.
              Write a function find_rhombus that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique rhombuses that can be using those points
               as corners. The rhombuses do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_rhombus(points: set) -> list:
        """Find rhombuses."""
        results = AIM.find_quadrilateral(points=points, rhombus=True)
        return results["rhombus"]

    @staticmethod
    def find_rectangle_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct rectangles
               that can be formed from those points.
              Rectangles are defined as having 4 sides, formed with 4 points. Four internal right angles,
               opposite sides of equal length.
               Each corner must form a 90 degree angle.
              Write a function find_rectangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique rectangles that can be using those points
               as corners. The rectangles do not need to be aligned with the x-y axes.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_rectangle(points: set) -> list:
        """Find rectangles."""
        results = AIM.find_quadrilateral(points=points, rectangle=True)
        return results["rectangle"]

    @staticmethod
    def find_square_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct squares
               that can be formed from those points.
              Squares are defined as having 4 sides, formed with 4 points. Four sides of equal length, four
               internal right angles.
              Write a function find_square that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique squares that can be using those points
               as corners. The squares do not need to be aligned with the x-y axes.
              For example, if points = {(-3, 0), (0, -3), (0, 3), (3, 0), (0, 0), (3, 3)}, then find_square(points)
               should return 2. As illustrated in the figure here (https://imgur.com/a/ygK9wfB), there are two
               squares that can be formed from these points: the blue diamond {(-3, 0), (0, -3), (3, 0), (0, 3)}
               and the green square {(0, 3), (3, 3), (3, 0), (0, 0)}.
              Make sure to give yourself enough time to implement a correct solution, then you can try to find
               solutions that have better asymptotic runtime.
              We are looking for production quality code, so please make sure your submission is clean and well
               documented. Also include any test cases you think would be helpful in validating correctness.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_square(points: set) -> list:
        """Find squares."""
        results = AIM.find_quadrilateral(points=points, square=True)
        return results["square"]

    @staticmethod
    def find_triangle_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              Triangles are defined as having 3 sides, formed with 3 non collinear points.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle(points: set, **kwargs) -> list:
        """Find triangles."""
        # No need to process points to remove duplicates. Sets do not allow duplicates
        """ Note: Shape definiopns: https://www.skillsyouneed.com/num/polygons.html
            Note: I did not see the same issue with sorting that was discovered with the rectangles, but I kept the
                   same logical flow just in case."""

        def in_and_true(shape: str = None):
            if shape is not None and kwargs:
                if shape in kwargs:
                    return kwargs.get(shape)
            return False

        # Convert set to list to allow iteration with index and sort for processing simplicity
        points_list = list(points)
        # Define output dictionary
        output_dictionary = {}
        for arg in kwargs:
            output_dictionary[arg] = list()
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
                    point_set = {points_list[p1index], points_list[p2index], points_list[p3index]}
                    # A Triangle must have 3 points and not have adjacent lines be collinear
                    if len(point_set) != 3:
                        continue
                    l2 = Line(p1=p2, p2=p3)
                    l3 = Line(p1=p3, p2=p1)
                    # The sum of the inner angles of a triangle must be 180 degrees
                    angle_list = [round(l1.get_angle(line2=l2), 5), round(l2.get_angle(line2=l3), 5),
                                  round(l3.get_angle(line2=l1), 5)]
                    if 180 != round(reduce(lambda x, y: x + y, angle_list), 3):
                        continue
                    # Verify that the 3 points are not collinear. If the angle between any 2 lines in 180,
                    # then this will be colinnear
                    if 180 in angle_list:
                        continue
                    angle_set = set(angle_list)
                    length_set = {round(l1.length(), 5), round(l2.length(), 5), round(l3.length(), 5)}
                    point_set = {points_list[p1index], points_list[p2index], points_list[p3index]}
                    if not len(point_set) == 3:
                        continue
                    # Determine the type of triangle to process.
                    if in_and_true("scalene"):
                        output_dictionary.get("scalene").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("acute"), all([True if angle < 90 else False for angle in angle_set])]):
                        output_dictionary.get("acute").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("obtuse"), any([True if angle > 90 else False for angle in angle_set])]):
                        output_dictionary.get("obtuse").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("right"), any([True if angle == 90 else False for angle in angle_set])]):
                        output_dictionary.get("right").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("isosceles"), len(length_set) <= 2]):
                        output_dictionary.get("isosceles").append(sorted(point_set, key=lambda x: (x[0], x[1])))
                    if all([in_and_true("equilateral"), len(length_set) == 1]):
                        output_dictionary.get("equilateral").append(sorted(point_set, key=lambda x: (x[0], x[1])))
        # Sort values and eliminate duplicates
        for key in output_dictionary:
            output_dictionary[key] = [list(x) for x in set(tuple(x) for x in output_dictionary.get(key))]
        return output_dictionary

    @staticmethod
    def find_triangle_scalene_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Scalene triangles are defined as having 3 sides, formed with 3 non collinear points. The 3 sides do not
               need to be the same length.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_scalene(points: set) -> list:
        """Find scalene triangles."""
        results = AIM.find_triangle(points=points, scalene=True)
        return results["scalene"]

    @staticmethod
    def find_triangle_acute_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Acute triangles are defined as having 3 sides, formed with 3 non collinear points. The 3 sides do not
               need to be the same length.  All angles must be less than 90 degrees.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_acute(points: set) -> list:
        """Find acute triangles."""
        results = AIM.find_triangle(points=points, acute=True)
        return results["acute"]

    @staticmethod
    def find_triangle_obtuse_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Obtuse triangles are defined as having 3 sides, formed with 3 non collinear points. The 3 sides do not
               need to be the same length.  1 angle must be greater than 90 degrees.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_obtuse(points: set) -> list:
        """Find obtuse triangles."""
        results = AIM.find_triangle(points=points, obtuse=True)
        return results["obtuse"]

    @staticmethod
    def find_triangle_right_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Right triangles are defined as having 3 sides, formed with 3 non collinear points. The 3 sides do not
               need to be the same length.  1 angle must be 90 degrees.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_right(points: set) -> list:
        """Find right triangles."""
        results = AIM.find_triangle(points=points, right=True)
        return results["right"]

    @staticmethod
    def find_triangle_isosceles_help():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Isosceles triangles are defined as having 3 sides, formed with 3 non collinear points. 2 sides must
               be the same length.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_isosceles(points: set) -> list:
        """Find isosceles triangles."""
        results = AIM.find_triangle(points=points, isosceles=True)
        return results["isosceles"]

    @staticmethod
    def help_find_triangle_equilateral():
        print("""              Given a set of distinct points in the x-y plane, find the number of distinct triangles
               that can be formed from those points.
              Equilateral triangles are defined as having 3 sides, formed with 3 non collinear points. All 3 sides
               must be the same length.  All 3 angles must be equal.
              Write a function triangle that takes in a set of tuples, where each tuple (x, y) represents
               a point the x-y plane, and computes the number of unique triangles that can be using those points
               as corners.
              A useful webpage to verify tests is: https://www.desmos.com/calculator""")

    @staticmethod
    def find_triangle_equilateral(points: set) -> list:
        """Find equilateral triangles."""
        results = AIM.find_triangle(points=points, equilateral=True)
        return results["equilateral"]
