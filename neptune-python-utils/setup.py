from setuptools import setup

setup(
   name='neptune_python_utils',
   version='1.0',
   description='Python 3 library that simplifies using Gremlin-Python to connect to Amazon Neptune',
   author='',
   author_email='',
   packages=['neptune_python_utils'],
   install_requires=['gremlinpython', 'requests', 'backoff', 'cchardet', 'aiodns', 'idna-ssl'], 
)
