terraform {
  required_providers {

    helm = {
      source  = "hashicorp/helm"
      version = "2.14.0"
    }

    cloudflare = {
      source  = "cloudflare/cloudflare"
      version = "4.37.0"
    }

    aws = {
      source  = "hashicorp/aws"
      version = "5.59.0"
    }
  }

  backend "s3" {
    bucket = "nicholasmeyers-api-skoda-prd-terraform-state"
    key    = "terraform.tfstate"
    region = "eu-west-1"
  }
}

provider "helm" {
  kubernetes {
    config_path = "~/.kube/config"
  }
}
