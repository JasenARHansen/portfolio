class PowersOfBase(object):
    elems = []

    @classmethod
    def addelem(cls, e):
        cls.elems.append(e)

    @staticmethod
    def addelem2(e):
        PowersOfBase.elems.append(e)
